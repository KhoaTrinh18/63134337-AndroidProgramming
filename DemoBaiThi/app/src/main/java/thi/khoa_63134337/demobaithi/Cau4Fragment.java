package thi.khoa_63134337.demobaithi;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Cau4Fragment extends Fragment {
    public Cau4Fragment() {
        // Required empty public constructor
    }

    public static Cau4Fragment newInstance(String param1, String param2) {
        Cau4Fragment fragment = new Cau4Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewCau4 = inflater.inflate(R.layout.fragment_cau4, container, false);
        SQLiteDatabase db = getActivity().openOrCreateDatabase("QLSach.db", // tên file = tên DB
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
        ListView lvBooks = viewCau4.findViewById(R.id.lvBooks);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(viewCau4.getContext(), android.R.layout.simple_list_item_1, dsTenSach);
        lvBooks.setAdapter(adapter);
        return viewCau4;
    }
}