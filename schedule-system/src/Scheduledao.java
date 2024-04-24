import java.util.List;

/**
 * ClassName: Scheduledao
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/4/26 19:42
 * @Version 1.0
 */
public class Scheduledao extends BaseDao implements  Secheduleim{
    @Override
    public int addSchedule(sysSchedule schedule) {
        String sql="insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows=baseUpdate(sql,schedule.getUid(),schedule.getTitle());
        return rows;
    }

    @Override
    public List<sysSchedule> findAll() {
        String sql ="select sid,uid,title,completed from sys_schedule";
        List<sysSchedule> sysSchedules = baseQuery(sysSchedule.class, sql);
        return sysSchedules;
    }
}
