/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.SeqTable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface SeqTableFacadeLocal {

    void create(SeqTable seqTable);

    void edit(SeqTable seqTable);

    void remove(SeqTable seqTable);

    SeqTable find(Object id);

    List<SeqTable> findAll();

    List<SeqTable> findRange(int[] range);

    int count();
    
}
