import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
import java.io.Serializable;
 
//This bean is required if you  use faces-config.xml 
 
@ManagedBean(name="resultBean")
@RequestScoped   //You can use @ViewScoped
public class ResultBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    public String result() {
 
        System.out.println("Inside Result Bean");
        return "success";
 
    }
 
}