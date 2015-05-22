package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import domain.Collection;
import domain.ID;
import domain.Key;
import domain.entity.Book;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by trieudoan on 5/20/2015.
 */
public class CrudService <T> {
    private MongoDatabase db;

    private Class<T> persistentClass;

    public CrudService(Class<T> persistentClass, MongoDatabase db) {
        this.persistentClass = persistentClass;
        this.db = db;
    }

    private List<Field> getAllFields(Class T) {
        List<Field> fields = new ArrayList<Field>();
        fields.addAll(Arrays.asList(T.getDeclaredFields()));

        if(T.getSuperclass() != null) {
            fields.addAll(getAllFields(T.getSuperclass()));
        }

        return fields;
    }

    private Field getIdField() {
        Field result = null;
        List<Field> fields = getAllFields(persistentClass);
        for(Field field : fields) {
            if(field.isAnnotationPresent(ID.class)) {
                result = field;
                break;
            }
        }

        return result;
    }

    public T create(T entity) throws IllegalAccessException, InstantiationException {
        Document document = createDocument(entity);
        db.getCollection(getCollectionName()).insertOne(document);
        return createByDocument(document);
    }

    public long update(T entity) throws IllegalAccessException {
        Document document = createDocument(entity);
        String idKey = getIdKey();
        ObjectId idValue = new ObjectId((String)getPropertyValue(getIdField(), entity));
        UpdateResult updateResult = db.getCollection(getCollectionName()).updateOne(new Document(idKey, idValue), new Document("$set", document));
        return updateResult.getModifiedCount();
    }

    public boolean delete(String id){
        DeleteResult deleteResult = db.getCollection(getCollectionName()).deleteOne(new Document(getIdKey(), new ObjectId(id)));
        return deleteResult.getDeletedCount()== 1 ? true : false;
    }

    public T get(String id) throws IllegalAccessException, InstantiationException {
        FindIterable<Document> iterable = db.getCollection(getCollectionName()).find(new Document(getIdKey(), new ObjectId(id)));
        Document document = iterable.first();
        return createByDocument(document);
    }

    private T createByDocument(Document document) throws InstantiationException, IllegalAccessException {
        if(document == null){
            return null;
        }

        T entity = createNewInstance();

        ObjectId id = document.getObjectId(getIdKey());

        if(id != null) {
            Field idField = getIdField();
            setPropertyValue(idField, entity, document.getObjectId(getIdKey()).toString());
        }

        Field[] fields = persistentClass.getDeclaredFields();
        for(Field field : fields) {
            if(field.isAnnotationPresent(Key.class)) {
                setPropertyValue(field, entity, document.get( getKeyOfField(field)));
            }
        }

        return entity;
    }

    private Document createDocument(T entity) throws IllegalAccessException {
        if(entity == null){
            return null;
        }

        Document document = new Document();
        Field idField = getIdField();
        if(idField != null) {
            String id = (String)getPropertyValue(getIdField(), entity);
            if (StringUtils.isNotEmpty(id)) {
                document.append(getIdKey(), new ObjectId(id));
            }
        }

        Field[] fields = persistentClass.getDeclaredFields();
        for(Field field : fields) {
            if(field.isAnnotationPresent(Key.class)) {
                String key = getKeyOfField(field);
                Object value = getPropertyValue(field,entity);
                document.append(getKeyOfField(field), value);
            }
        }

        return document;
    }

    private T createNewInstance() throws IllegalAccessException, InstantiationException {
        T instance = persistentClass.newInstance();
        return instance;
    }

    private String getIdKey(){
        Field idField = getIdField();
        if(idField == null){
            return null;
        }
        ID annotationId = idField.getAnnotation(ID.class);
        return annotationId.value();
    }

    private String getKeyOfField(Field field){
        Key annotationKey = field.getAnnotation(Key.class);
        return annotationKey.value();
    }

    private String getCollectionName(){
        return  this.persistentClass.getAnnotation(Collection.class).value();
    }

    private Object getPropertyValue(Field field, Object entity) throws IllegalAccessException{
        field.setAccessible(true);
        return field.get(entity);
    }

    private void setPropertyValue(Field field, Object entity, Object value) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(entity, value);
    }

    public List<T> getAll() throws IllegalAccessException, InstantiationException {
        FindIterable<Document> iterable = db.getCollection(getCollectionName()).find();
        List<T> entities = new ArrayList<T>();
        for (Document document : iterable){
            T entity = createByDocument(document);
            entities.add(entity);
        }

        return entities;
    }
}
