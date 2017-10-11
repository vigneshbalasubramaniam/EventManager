/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventmgr.domain;

/**
 *
 * @author vi391762
 */
public class Location {
    private int id;
    private String name;
    private String address;
    public Location()
    {
    }
    public Location(String name,String address)
    {
        this.name=name;
        this.address=address;
    }
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String toString( ) {
	return String.format( "[%d] %s at %s", id, name, address );
}

}
