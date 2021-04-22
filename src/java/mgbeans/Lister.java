
package mgbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import pojos.Client;
import pojos.Position;


@ManagedBean
@SessionScoped
public class Lister {

    String positionName;
    List<Client> clients;
    List<Position> positions;
    Client selectedClient;
    Position selectedPosition;
    
    public Lister() {
        Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
        clients = session.createQuery("FROM Client").list();
        positions = session.createQuery("FROM Position").list();
        session.close();
    }
    
}
