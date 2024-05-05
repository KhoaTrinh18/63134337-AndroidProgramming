package khoatrinh.example_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        // B1. Tạo file cơ sở dữ liệu
//        SQLiteDatabase db = openOrCreateDatabase("QLSach.db", // Tên file = tên DB
//                                                 MODE_PRIVATE, // Giới hạn truy cập
//                                                null // Con trỏ bản ghi
//                                                );
//        // B2. Tạo bảng
//        // Câu lệnh tạo bảng
//        String sqlXoaBangNeuDaCo = "DROP TABLE IF EXISTS Books";
//        String sqlTaoBang = "CREATE TABLE Books( BookID integer PRIMARY KEY, " +
//                                                "BookName text, " +
//                                                "Page integer, " +
//                                                "Price Float, " +
//                                                "Description text);";
//        // B3. Thực hiện lệnh sql
//        db.execSQL(sqlXoaBangNeuDaCo);
//        db.execSQL(sqlTaoBang);
//        // Thêm một số dòng dữ liệu vào bảng
//        String sqlThem1 = "INSERT INTO Books VALUES(1, 'Java', 100, 9.99, 'sách về java');";
//        String sqlThem2 = "INSERT INTO Books VALUES(2, 'Android', 320, 19.00, 'Android cơ bản');";
//        String sqlThem3 = "INSERT INTO Books VALUES(3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui');";
//        String sqlThem4 = "INSERT INTO Books VALUES(4, 'Tử điển Anh-Việt', 1000, 29.50, 'Từ điển 100.000 từ');";
//        String sqlThem5 = "INSERT INTO Books VALUES(5, 'CNXH', 1, 1, 'chuyện cổ tích');";
//        db.execSQL(sqlThem1);
//        db.execSQL(sqlThem2);
//        db.execSQL(sqlThem3);
//        db.execSQL(sqlThem4);
//        db.execSQL(sqlThem5);
//        // Để quan sát trực quan file .db ? ==> Dùng ứng dụng DB Browser for SQLite
//        // Để mở được, ta save file từ điện thoại ra đĩa cứng
//        // B4. Ta đóng lại để check
//        db.close();

        // Truy vấn SELECT
        // B1. Mở CSDL
        SQLiteDatabase db = openOrCreateDatabase("QLSach.db", // tên file = tên DB
                                                MODE_PRIVATE,  // Giới hạn truy cập
                                                null // Con trỏ bản ghi
                                                );
        // B2. Thực thi câu lệnh SELECT
        String sqlSelect ="SELECT * FROM Books;";
        Cursor cs = db.rawQuery(sqlSelect,null);
        cs.moveToFirst(); // Đưa con trỏ bản ghi về hàng đầu tiên
        // B3. Đổ vào biến nào đó để xử lý
        // 3.1. Xây dựng model/class cho bảng Books, vi dụ: Book.java
        // 3.2. Tạo biến ArrayList<Book> dsSach;
        ArrayList<Book> dsSach = new ArrayList<>();
        // 3.3. Duyệt qua lần lượt từng bản ghi và thêm vào danh sách sách
        while (cs.moveToNext()) // Còn bản ghi để chuyển tới
        {
            // Lấy dữ liệu từng cột ở dòng hiện tại
            int idSach = cs.getInt(0);  // lấy dữ liệu ở côt 0, kiểu int
            String tenSach = cs.getString(1);
            int soTrang = cs.getInt(2);
            float gia = cs.getFloat(3);
            String mota = cs.getString(4);
            // Tạo một đối tượng sách và thêm vào danh sách sách
            Book b = new Book(idSach, tenSach, soTrang, gia, mota);
            dsSach.add(b);
        }
        // B4. Hiện lên listview, recylerview,..
        // Hiện tên sách
        ArrayList<String> dsTenSach = new ArrayList<>();
        for (int i=0; i<dsSach.size(); i++ )
            dsTenSach.add(dsSach.get(i).getBookName());
    }
}