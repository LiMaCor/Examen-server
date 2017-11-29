package Dao.publicinterface;

public interface TableDaoInterface<GenericTableBean> {

    public GenericTableBean get(int id, int intExpand) throws Exception;

    public Integer set(GenericTableBean oBean) throws Exception;

    public int remove(Integer id) throws Exception;

}
