package example;

/**
 * Created by Administrator on 2019/4/3.
 */
public interface AdminMapper {
    public Admin getAdmin(Integer id);
    public int deleteAdmin(Integer id);
    public int InsertAdmin(Admin id);
}
