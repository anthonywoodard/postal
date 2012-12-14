package org.stjude.postal.model.dao;

import org.stjude.postal.model.domain.State;
import org.stjude.postal.model.exceptions.StateDAOException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kev
 * Date: 11/12/12
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */
public interface StateDAO
{
    State findByAbbr(String abbr)
            throws StateDAOException;

    List<State> findAll()
            throws StateDAOException;

    List<State> findByName(String name)
            throws StateDAOException;
}