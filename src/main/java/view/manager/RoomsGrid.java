package view.manager;

import model.Room;
import repo.Repository;
import service.RoomService;
import view.Grid;
import view.menu.ManagerMenu;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Objects;

public class RoomsGrid extends Grid {

    public RoomsGrid(){
        super("rooms");
        this.setName("RoomsGrid");
        initTable();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new ManagerMenu();
            }
        });
        addButton.addActionListener(e -> add());
        editButton.addActionListener(e -> edit());
    }

    private void initTable(){
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        String[] header = new String[] {"bedCount", "price", "allowed", "no"};
        dtm.setColumnIdentifiers(header);
        table.setModel(dtm);

        List<Room> list = RoomService.getInstance().findAll();
        for (Room r : list) {
            String bedCount = (r.getBedCount() != null) ? r.getBedCount().toString() : "";
            String price = (r.getPrice() != null) ? r.getPrice().toString() : "";
            String allowed = (r.getAllowed() != null) ? r.getAllowed().toString() : "";
            long id = (r.getId() != null) ? r.getId() : 0L;
            dtm.addRow(new Object[] { bedCount, price, allowed, id});
        }
    }

    private void edit(){
        Frame current = Repository.getFrames().get("RoomsDialog");
        if (!Objects.isNull(current))
            current.dispose();
        int row = table.convertRowIndexToModel(table.getSelectedRow());
        Long value = (Long) table.getModel().getValueAt(row, 3);
        new RoomsDialog(value , true);
    }

    private void add(){
        new RoomsDialog(0, false);
    }
}
