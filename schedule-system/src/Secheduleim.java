import java.util.List;

/**
 * ClassName: Secheduleim
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/4/26 19:30
 * @Version 1.0
 */
public interface Secheduleim {
    int addSchedule(sysSchedule schedule);
    List<sysSchedule> findAll();
}
