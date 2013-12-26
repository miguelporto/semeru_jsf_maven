/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.semeru.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 *
 * @author miguelporto
 */
public class PhaseListenerSemeru implements PhaseListener{

   
     @Override
    public void beforePhase(PhaseEvent fase) {
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
            System.out.println("Antes da fase " + getPhaseId());
            
            Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
            session.beginTransaction();
            FacesContexUtil.setRequestSession(session);
        }
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        if (event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            System.out.println("Depois da fase "+getPhaseId());
            
          Session session = FacesContexUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                    
                }
            }
            finally{
                session.close();
            }
        }
    }

   
    @Override
    public PhaseId getPhaseId() {
       return PhaseId.ANY_PHASE;
    }
    
}
