package com.zhi.Service;

import com.zhi.domain.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
public class ContactService {
    public List<Contact> getContacts(){
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact(1,"张天师",234, "123456"));
        contacts.add(new Contact(2,"理工",54, "1285645686"));
        contacts.add(new Contact(3,"月娥",63, "1568245686"));
        contacts.add(new Contact(4,"婆娑",68, "18888"));
        contacts.add(new Contact(5,"无忧",189, "122222"));
        contacts.add(new Contact(6,"邮箱",235, "133333"));
        return contacts;
    }
}
