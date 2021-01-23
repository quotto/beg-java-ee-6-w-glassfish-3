package org.beginningee6.book.chapter07.ex09;

import java.util.List;

import javax.ejb.Local;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Local
public interface ItemLocal09 {

    // ======================================
    // =           Public Methods           =
    // ======================================
    List<Book09> findBooks();

    List<CD09> findCDs();

    Book09 findBookById(Long id);

    CD09 findCDById(Long id);
}