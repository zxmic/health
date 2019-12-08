import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zx
 */
public class UserAction extends ActionSupport {
    public String add() {
        System.out.println("----- add -----");
        return "add";
    }
}
