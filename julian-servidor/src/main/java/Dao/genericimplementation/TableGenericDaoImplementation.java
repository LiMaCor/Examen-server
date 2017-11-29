package Dao.genericimplementation;

import Bean.genericimplementation.TableGenericBeanImplementation;
import Bean.genericimplementation.ViewGenericBeanImplementation;
import Bean.publicinterface.GenericBeanInterface;
import Bean.specificimplementation.UsuarioSpecificBeanImplementation;
import Helper.Log4jConfigurationHelper;
import Helper.MappingBeanHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Dao.publicinterface.TableDaoInterface;
import java.util.ArrayList;

public abstract class TableGenericDaoImplementation extends ViewGenericDaoImplementation implements TableDaoInterface<TableGenericBeanImplementation> {

    public TableGenericDaoImplementation(String ob, Connection oPooledConnection, UsuarioSpecificBeanImplementation oPuserBean_security, String strWhere) {
        super(ob, oPooledConnection, oPuserBean_security, strWhere);
    }

    @Override
    public TableGenericBeanImplementation get(int id, int intExpand) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL += " AND id=? ";
        TableGenericBeanImplementation oBean = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setInt(1, id);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                oBean = (TableGenericBeanImplementation) MappingBeanHelper.getBean(ob);
                oBean = (TableGenericBeanImplementation) oBean.fill(oResultSet, oConnection, oPuserSecurity, intExpand);

            } else {
                oBean = null;
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }

        }
        return oBean;
    }

    @Override
    public Integer set(TableGenericBeanImplementation oBean) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        Integer iResult = 0;
        Boolean insert = true;
        try {
            if (oBean.getId() == null || oBean.getId() == 0) {
                strSQL = "INSERT INTO " + ob;
                strSQL += "(" + oBean.getColumns() + ")";
                strSQL += " VALUES ";
                strSQL += "(" + oBean.getValues() + ")";
                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
                iResult = oPreparedStatement.executeUpdate();
            } else {
                insert = false;
                strSQL = "UPDATE " + ob;
                strSQL += " SET ";
                strSQL += oBean.toPairs();
                strSQL += " WHERE id=? ";
                oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
                oPreparedStatement.setInt(1, oBean.getId());
                iResult = oPreparedStatement.executeUpdate();
            }
            if (iResult < 1) {
                String msg = this.getClass().getName() + ": set";
                Log4jConfigurationHelper.errorLog(msg);
                throw new Exception(msg);
            }
            if (insert) {
                oResultSet = oPreparedStatement.getGeneratedKeys();
                oResultSet.next();
                iResult = oResultSet.getInt(1);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (insert) {
                if (oResultSet != null) {
                    oResultSet.close();
                }
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }

    @Override
    public int remove(Integer id) throws Exception {
        int iResult = 0;
        strSQL = "DELETE FROM " + ob + " WHERE id=?";
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setInt(1, id);
            iResult = oPreparedStatement.executeUpdate();
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }

    public String getNombre(int id) throws Exception {
        String nombre = "";
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "SELECT * FROM " + ob + " WHERE 1=1 ";
        strSQL += " AND id=" + id;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                switch (ob) {
                    case "nombremasculino":
                        nombre = oResultSet.getString("nombre");
                        break;
                    case "nombrefemenino":
                        nombre = oResultSet.getString("nombre");
                        break;
                    case "apellido":
                        nombre = oResultSet.getString("apellido");
                        break;
                    case "via":
                        nombre = oResultSet.getString("via");
                        break;
                    case "municipio":
                        nombre = oResultSet.getString("nombre");
                        break;
                    case "provincia":
                        nombre = oResultSet.getString("provincia");
                        break;
                    case "comunidad":
                        nombre = oResultSet.getString("comunidad");
                        break;
                    default:
                        nombre = oResultSet.getString("nombre");
                        break;
                }
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }

        }
        return nombre;
    }

    public int getIdProvincia(String str) throws Exception {
        int id;
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "SELECT * FROM " + ob + " WHERE 1=1 ";
        strSQL += " AND nombre LIKE " + "'" + str + "'";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                id = oResultSet.getInt("id_provincia");
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return id;
    }
    
    public int getIdComunidad(String str) throws Exception {
        int id;
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "SELECT * FROM " + ob + " WHERE 1=1 ";
        strSQL += " AND nombre LIKE " + "'" + str + "'";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                id = oResultSet.getInt("id_comunidad");
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return id;
    }

    public ArrayList<ViewGenericBeanImplementation> dump() throws Exception {
        ArrayList<ViewGenericBeanImplementation> aloBean = new ArrayList<>();
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            while (oResultSet.next()) {
                GenericBeanInterface oBean = MappingBeanHelper.getBean(ob);
                oBean = (ViewGenericBeanImplementation) oBean.fill(oResultSet, oConnection, oPuserSecurity, null);
                aloBean.add((ViewGenericBeanImplementation) oBean);
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return aloBean;
    }

}
