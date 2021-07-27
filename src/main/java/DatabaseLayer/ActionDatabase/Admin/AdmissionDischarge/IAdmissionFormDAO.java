package DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge;

import BusinessLogicLayer.BeanClasses.Admission;

import java.sql.SQLException;

public interface IAdmissionFormDAO {
    int saveAdmissionForm(Admission admission) throws SQLException;
    
    int updateAdmissionForm(Admission admission) throws SQLException;
}
