package DatabaseLayer.ActionDatabase.Admin.Wards;

import BusinessLogicLayer.BeanClasses.Ward;

import java.util.List;

public interface IWardDAO {

  Ward getWard(int wardId);

  List<Ward> getWardsList();

  int addWard(Ward ward);

  void updateWard(String str, int id);
}
