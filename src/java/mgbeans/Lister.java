
package mgbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Client;
import pojos.Position;


@ManagedBean
@SessionScoped
public class Lister {

    private String positionName;
    private List<Client> clients;
    private List<Position> positions;
    private Client selectedClient;
    private Position selectedPosition;
    
    public Lister() {
        Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
        clients = session.createQuery("FROM Client").list();
        positions = session.createQuery("FROM Position").list();
        session.close();
    }
    
    public void searchPosition(){
        Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Position WHERE jobName LIKE :pposition");
        query.setString("pposition", "%" + positionName + "%");
        positions = query.list();
        session.close();
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

    public Position getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(Position selectedPosition) {
        this.selectedPosition = selectedPosition;
    }
    
    
    
    
    
}
