/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventmgr.domain;

/**
 *
 * @author VI391762
 */
public class Speaker {
    private int id;
    private String name;
    private String telephone;
    public Speaker()
    {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public Speaker(String name,String telephone)
    {
        this.name=name;
        this.telephone=telephone;
    }

    @Override
    public String toString() {
        return "Speaker{" + "id=" + id + ", name=" + name + ", telephone=" + telephone + '}';
    }
    
}
