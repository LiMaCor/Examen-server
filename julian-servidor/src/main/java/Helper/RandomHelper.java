package Helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Julian
 */
public class RandomHelper {

    String strSQL = null;
    Connection oConnection = null;
    PreparedStatement oPreparedStatement = null;
    ResultSet oResultSet = null;

    public int getSexo() {
        int sexo = randInt(1, 2);

        return sexo;
    }

    public String getNombre(int sexo) throws SQLException {
        String nombre = "";
        if (sexo == 1) {
            strSQL = "SELECT nombre FROM nombremasculino ";
            strSQL += "ORDER BY RAND() ";
            strSQL += "LIMIT 1; ";

            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);

            while (oResultSet.next()) {
                nombre = oResultSet.getString("nombre");
            }
        } else {
            strSQL = "SELECT nombre FROM nombrefemenino ";
            strSQL += "ORDER BY RAND() ";
            strSQL += "LIMIT 1; ";

            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);

            while (oResultSet.next()) {
                nombre = oResultSet.getString("nombre");
            }
        }
        return nombre;
    }

    public String getApellido() throws SQLException {
        String apellido = "";
        strSQL = "SELECT apellido FROM apellido ";
        strSQL += "ORDER BY RAND() ";
        strSQL += "LIMIT 1; ";

        oPreparedStatement = oConnection.prepareStatement(strSQL);
        oResultSet = oPreparedStatement.executeQuery(strSQL);

        while (oResultSet.next()) {
            apellido = oResultSet.getString("apellido");
        }
        return apellido;
    }

    public String getDireccion() throws SQLException {
        String direccion = "";

        direccion += getVia();
        direccion += " ";
        direccion += "de";
        direccion += " ";
        direccion += getNombre(getSexo());
        direccion += " ";
        direccion += getApellido();

        return direccion;
    }

    public String getMunicipio() throws SQLException {
        String municipio = "";
        strSQL = "SELECT via FROM via ";
        strSQL += "ORDER BY RAND() ";
        strSQL += "LIMIT 1; ";

        oPreparedStatement = oConnection.prepareStatement(strSQL);
        oResultSet = oPreparedStatement.executeQuery(strSQL);

        while (oResultSet.next()) {
            municipio = oResultSet.getString("municipio");
        }
        return municipio;
    }

    public int getCodPostal() {
        int codPostal = randInt(46000, 46999);

        return codPostal;
    }

    public int getTelefono1() {
        int telefono = 0;
        int rand = randInt(1, 2);
        if (rand == 1) {
            telefono = randInt(640000000, 649999999);
        } else {
            telefono = randInt(620000000, 629999999);
        }
        return telefono;
    }

    public int getTelefono2(int tel1) {
        int telefono = tel1;
        int rand = randInt(1, 2);
        while (telefono == tel1) {
            if (rand == 1) {
                telefono = randInt(640000000, 649999999);
            } else {
                telefono = randInt(620000000, 629999999);
            }
        }
        return telefono;
    }

    public int getTipoPago() {
        int tipoPago = randInt(1, 5);

        return tipoPago;
    }

    public String getVia() throws SQLException {
        String via = "";
        strSQL = "SELECT via FROM via ";
        strSQL += "ORDER BY RAND() ";
        strSQL += "LIMIT 1; ";

        oPreparedStatement = oConnection.prepareStatement(strSQL);
        oResultSet = oPreparedStatement.executeQuery(strSQL);

        while (oResultSet.next()) {
            via = oResultSet.getString("via");
        }
        return via;
    }

    public static int randInt(int min, int max) {
        int rand = (int) Math.floor(Math.random() * (min - max + 1) + max);
        return rand;
    }

    public Long randomLongNumber(String columna, String strTable) throws Exception {
        Long iResult = 0L;
        Random rand = new Random();
        Long aleatorio;
        strSQL = "SELECT COUNT(" + columna + ") FROM " + strTable;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                iResult = oResultSet.getLong("COUNT(" + columna + ")");
            } else {
                throw new Exception();
            }
            int minimo = 1;
            Long maximo = iResult;
            aleatorio = rand.nextLong() * (maximo - minimo);

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
        return aleatorio;
    }

    public static Date randomFecha() throws Exception {
        Date startDate = new GregorianCalendar(1945, Calendar.JANUARY, 1).getTime();
        Date endDate = new GregorianCalendar(2015, Calendar.JANUARY, 1).getTime();
        long random = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
        Date date = new Date(random);
        return date;
    }

    public static Long randomLong() {
        Long min = 1L;
        Long max = 9999999999L;
        Random random = new Random();
        long longRandom = min + (long) (random.nextDouble() * (max - min));
        return longRandom;
    }

}
