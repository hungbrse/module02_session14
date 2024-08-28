package module02_session14.feature;

public interface IGenericFeature <T,E>{
   void addOrUpdate(T item);
   void delete(E id);
    int findIndexbyid(E id);
}
