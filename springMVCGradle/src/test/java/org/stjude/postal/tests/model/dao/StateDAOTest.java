package org.stjude.postal.tests.model.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;
import org.stjude.postal.model.domain.State;
import org.stjude.postal.model.exceptions.StateDAOException;
import org.stjude.postal.model.impl.StateDAOImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: karmstrong
 * Date: 11/14/12
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = {"/test-config.xml"})
public class StateDAOTest extends AbstractJUnit4SpringContextTests {
    private StateDAOImpl stateDAO;

    @Autowired
    public void setStateDAO(StateDAOImpl stateDAO) {
        this.stateDAO = stateDAO;
    }

    @Test
    public void getListOfStates(){
        List<State> list;
        try {
            list = stateDAO.findAll();
            Assert.isTrue(list.size() == 51, "The list should have 51 states.");
            Assert.isTrue(list.get(0).getState().equalsIgnoreCase("Alabama"), "The first state should be Alabama");
        } catch (StateDAOException sde) {
        }
    }

    @Test
    public void getStateByAbbr(){
        State state;
        try {
            state = stateDAO.findByAbbr("TN");
            Assert.isTrue(state.getState().equals("Tennessee"), "The abbreviation 'TN' should retrieve the state Tennessee.");
            state = stateDAO.findByAbbr("ME");
            Assert.isTrue(state.getState().equals("Maine"), "The abbreviation 'ME' should retrieve the state Maine.");
        } catch (StateDAOException sde) {
        }
    }
}
