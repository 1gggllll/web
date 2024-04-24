import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * ClassName: sysUser
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/4/24 20:53
 * @Version 1.0
 */

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class sysUser implements Serializable {
    private Integer uid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        sysUser sysUser = (sysUser) o;
        return Objects.equals(uid, sysUser.uid) && Objects.equals(username, sysUser.username) && Objects.equals(userPwd, sysUser.userPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, userPwd);
    }

    private String username;
    private String userPwd;

   public sysUser() {
   }

   public sysUser(Integer uid, String username, String userPwd) {
       this.uid = uid;
       this.username = username;
       this.userPwd = userPwd;
   }

   public void setUid(Integer uid) {
       this.uid = uid;
   }

   public void setUsername(String username) {
       this.username = username;
   }

   public void setUserPwd(String userPwd) {
       this.userPwd = userPwd;
   }

   public Integer getUid() {
       return uid;
   }

   public String getUsername() {
       return username;
   }

   public String getUserPwd() {
       return userPwd;
    }
}
