package net.sourceforge.seqware.common.dao.hibernate;

import java.util.List;
import net.sourceforge.seqware.common.dao.ExperimentAttributeDAO;
import net.sourceforge.seqware.common.model.Experiment;
import net.sourceforge.seqware.common.model.ExperimentAttribute;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * ExperimentAttributeDAOHibernate class.
 * </p>
 *
 * @author boconnor
 * @version $Id: $Id
 */
public class ExperimentAttributeDAOHibernate implements ExperimentAttributeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private SessionFactory currentSessionFactory() {
        return sessionFactory;
    }

    /** {@inheritDoc} */
    @Override
    public void insert(ExperimentAttribute experimentAttribute) {
        currentSessionFactory().getCurrentSession().save(experimentAttribute);

    }

    /** {@inheritDoc} */
    @Override
    public void update(ExperimentAttribute experimentAttribute) {
        currentSessionFactory().getCurrentSession().saveOrUpdate(experimentAttribute);
    }

    /** {@inheritDoc} */
    @Override
    public void delete(ExperimentAttribute experimentAttribute) {
        currentSessionFactory().getCurrentSession().delete(experimentAttribute);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public List<ExperimentAttribute> findAll(Experiment experiment) {
        String queryString = "from ExperimentAttribute as ea where ea.experiment.experimentId = :experimentId";
        Query query = currentSessionFactory().getCurrentSession().createQuery(queryString);
        query.setLong("experimentId", experiment.getExperimentId());
        return query.list();
    }

    @Override
    public List<ExperimentAttribute> list() {
        Query query = currentSessionFactory().getCurrentSession().createQuery("from ExperimentAttribute");
        return query.list();
    }
}
