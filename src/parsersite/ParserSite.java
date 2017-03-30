/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsersite;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * https://www.stroyteh.ru/sale/xml/?mark=%D0%93%D0%90%D0%97&model=3302&mileageMax=10000 /tmp/1.log 70000
 *
 * @author evgeniy
 */
public class ParserSite {

    public static final Logger log = Logger.getLogger(ParserSite.class.getName());

    public static void main(String[] args) {

        try {

            String base_url = args[0];
            String log_path = args[1];
            String min_cost = args[2];

            List<Item> mas = new ArrayList();

            /*  Loger */
            FileHandler fh;
            fh = new FileHandler(log_path, true);
            fh.setFormatter(new SimpleFormatter());
            fh.setEncoding("UTF-8");
            log.addHandler(fh);
            log.setLevel(Level.ALL);

            Items items = (Items) new JaxbParser().getObject(new URL(base_url), Items.class);
            for (Item item : items.getMembers()) {
                mas.add(item);
            }

            // Sorting
//        Collections.sort(mas, new Comparator<Item>() {
//
//            @Override
//            public int compare(Item item2, Item item1) {
//                return item2.cost - item1.cost;
//            }
//        });
            for (Item item : mas) {
                System.out.println(item.title + " " + item.cost);
                System.out.println(item.link);
            }

        } catch (IOException ex) {
            log.log(Level.WARNING, ex.getMessage());
        }

    }

}
