package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Ward;

public interface IUpdateWardsDAO {

  void updateWard(String str, int id);

  Ward getWardDetails(int id);

}
