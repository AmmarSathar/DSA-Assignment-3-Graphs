/** Author: Ammar_Sathar_40182146 */
package coen352.ch4.dictionary;
import coen352.ch4.list.*;
public class DListDictionary<Key, E> implements ADTDictionary<Key, E> {



    private DList<Key> klist;
    private DList<E> vlist;

//    private Link<Key> khead; // Pointer to klist header
//    private Link<Key> ktail; // Pointer to last element in klist
//    protected Link<Key> kcurr; // Access to current element in klist
//
//    private Link<E> vhead; // Pointer to list vheader
//    private Link<E> vtail; // Pointer to last element in vlist
//    protected Link<E> vcurr; // Access to current element in vlist
//
//    private int kcnt; // length of klist
//    private int vcnt; // length of vlist

    /**
     * Constructors
     */
    public DListDictionary(int size) { this(); } // Constructor -- Ignore size

    public DListDictionary() {
        klist = new DList<>();
        vlist = new DList<>();
    }

    /**
     * Reinitialize
     */
    @Override
    public void clear() {
        klist.clear();
        vlist.clear();
    }

    @Override
    public void insert(Key new_k, E new_e) {
        klist.insert(new_k);
        vlist.insert(new_e);
    }


    @Override
    public E remove(Key k) {
        int currKeyPos = klist.currPos();
        int currValPos = vlist.currPos();

        klist.moveToPos(klist.find(k));
        vlist.moveToPos(klist.find(k));

        if ((klist.remove() != null) || (vlist.remove() != null))
            throw new AssertionError("Entry does not exist to remove");
        klist.remove();
        vlist.remove();



        return null;
    }

    @Override
    public E removeAny() {

        klist.remove();
        vlist.remove();
        return null;
    }


    /** The find function takes a key, records current position
     of the index in the linked list, moved both key and value list to start,
     traverses the list until key is matched, moves the vlist to that matched index
     and finally returns the value at matched index */
    @Override
    public E find(Key k) {

        E value;
        if(klist.getValue(klist.find(k))!= null) {
            value = vlist.getValue(klist.find(k));
            return value;
        }

        return null;
    }

    @Override
    public int size() {
        return klist.length();
    }


}
