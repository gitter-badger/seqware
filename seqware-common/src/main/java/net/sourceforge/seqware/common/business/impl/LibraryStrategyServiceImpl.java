package net.sourceforge.seqware.common.business.impl;

import java.util.List;
import net.sourceforge.seqware.common.business.LibraryStrategyService;
import net.sourceforge.seqware.common.dao.LibraryStrategyDAO;
import net.sourceforge.seqware.common.model.LibraryStrategy;
import net.sourceforge.seqware.common.model.Registration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * LibraryStrategyServiceImpl class.
 * </p>
 * 
 * @author boconnor
 * @version $Id: $Id
 */
public class LibraryStrategyServiceImpl implements LibraryStrategyService {
    private LibraryStrategyDAO dao = null;
    private static final Log LOG = LogFactory.getLog(LibraryStrategyServiceImpl.class);

    /**
     * <p>
     * Constructor for LibraryStrategyServiceImpl.
     * </p>
     */
    public LibraryStrategyServiceImpl() {
        super();
    }

    /**
     * {@inheritDoc}
     * 
     * Sets a private member variable with an instance of an implementation of StudyTypeDAO. This method is called by the Spring framework
     * at run time.
     * 
     * @see StudyTypeDAO
     */
    @Override
    public void setLibraryStrategyDAO(LibraryStrategyDAO dao) {
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public List<LibraryStrategy> list(Registration registration) {
        return dao.list(registration);
    }

    /** {@inheritDoc} */
    @Override
    public LibraryStrategy findByID(Integer id) {
        LibraryStrategy obj = null;
        if (id != null) {
            try {
                obj = dao.findByID(id);
            } catch (Exception exception) {
                LOG.error("Cannot find LibraryStrategy by id " + id);
                LOG.error(exception.getMessage());
            }
        }
        return obj;
    }

    /** {@inheritDoc} */
    @Override
    public LibraryStrategy updateDetached(LibraryStrategy strategy) {
        return dao.updateDetached(strategy);
    }

    /** {@inheritDoc} */
    @Override
    public List<LibraryStrategy> list() {
        return dao.list();
    }
}
