/** Author: Ammar_Sathar_40182146 */
package coen352.ch4.dictionary;

import coen352.ch4.list.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ListDictionary<Key, E> implements ADTDictionary<Key, E> {

    private static final int defaultSize = 100; // Default size

    private LList<Key> klist;
    private LList<E> vlist;

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
    public ListDictionary(int size) { this(); } // Constructor -- Ignore size

    public ListDictionary() {
       klist = new LList<>();
       vlist = new LList<>();
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
        if(this.find(new_k)!=null)
            throw new AssertionError("Entry already exists");
        //klist.moveToEnd();
        //vlist.moveToEnd();
        klist.insert(new_k);
        vlist.insert(new_e);
    }


    @Override
    public E remove(Key k) {
        int currKeyPos = klist.currPos();
        int currValPos = vlist.currPos();
        E value;

        if (vlist.getValue(klist.find(k)) == null) {

            throw new AssertionError("Entry does not exist to remove");

        } else {
            value = vlist.getValue(klist.find(k));
            klist.moveToPos(klist.find(k));
            vlist.moveToPos(klist.find(k));
            klist.remove();

        }
        return value;
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

    public void moveToStart(){
        klist.moveToStart();
        vlist.moveToStart();
    }

    public void moveNext(){
        klist.next();
        vlist.next();
    }

    public void moveToPos(int pos){
        klist.moveToPos(pos);
        vlist.moveToPos(pos);
    }

    public int getCurrPos(){
        return klist.currPos();
    }

    public E getValue(){
        return vlist.getValue();

    }

    public LList<E> createListIndex(String attribute){
        LList<Key> klistcopy = new LList<>();
        LList<E> vlistcopy = new LList<>();
        String methodName = "get"+attribute;
        this.moveToStart();
        for(int pos = 0; pos<this.size();pos++){
            klistcopy.insert(klist.getValue());
            vlistcopy.insert(vlist.getValue());
            this.moveNext();
        }
        return vlistcopy;

//        Class<?> clazz = vlistcopy.getValue().getClass();
//
//        // Find the method with the specified name
//        Method method = clazz.getMethod(methodName, int.class); // Assuming 'get' takes an int parameter
//
//        // Invoke the method on the object (for example, let's call it with index 0)
//        Object result = method.invoke(vlistcopy, 0);
    }
}
