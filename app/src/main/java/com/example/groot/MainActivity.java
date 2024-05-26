package com.example.groot;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = new DatabaseManager(this);
        try{
            db.open();
        } catch (Exception e){
            e.printStackTrace();
        }

        Cursor cursor = db.fetch(null,null);

        Log.d("EXCEC_INITIAL", String.valueOf(cursor.getCount()));

        if (cursor.getCount() == 0){

        db.insert(1,"Almon", "Shorea almon", "The Almon tree, known scientifically as Shorea almon, is a tropical hardwood species belonging to the Dipterocarpaceae family. Native to the Philippines, it is highly regarded for its durable and high-quality timber. Typically found in lowland dipterocarp forests, the Almon tree can grow to impressive heights.", "Philippines", "The wood of the Almon tree is highly valued in the timber industry due to its strength and durability. It is commonly used in construction for flooring, furniture, cabinetry, and boat building. Additionally, Almon wood is utilized in the production of veneers and plywood. Its aesthetic appeal and workability make it a popular choice for various woodworking projects.", "Almon trees can reach heights of up to 45 meters with trunk diameters growing up to 1.5 meters. The leaves are simple, alternate, and oblong to elliptic in shape, typically measuring 8-15 cm in length. The tree produces small, creamy-white flowers that grow in clusters, and its fruit is a winged nut, aiding in wind dispersal.", "To care for an Almon seedling, choose a planting site with well-drained, fertile soil and adequate sunlight. Keep the soil consistently moist, especially during the seedling’s early growth stages, and use a balanced fertilizer to promote healthy growth, following the manufacturer’s instructions. Applying a layer of mulch around the base of the seedling will help retain soil moisture and reduce weed competition. Protect the seedling from strong winds and direct sun exposure by providing partial shade or using protective barriers, and regularly monitor for signs of pests or diseases, taking appropriate action if any issues are detected.", "Borers, Leaf Miners, Scale Insects ,Termites");
//        db.insert(2,"Oak", "Quercus", "A deciduous tree with lobed leaves and acorns.", "Northern Hemisphere", "Timber, Furniture, Flooring", "Large tree with a strong, spreading canopy.", "Prefers well-drained, slightly acidic soil.", "Oak wilt, gypsy moth");
//        db.insert(3,"Pine", "Pinus", "An evergreen tree with needle-like leaves and cones.", "Northern Hemisphere", "Timber, Pulpwood, Construction", "Tall tree with a straight trunk and whorls of branches.", "Susceptible to pine beetle infestation and fire blight.", "Bark beetles, pine blister rust");
//        db.insert(4,"Palm", "Arecaceae Family", "A tropical or subtropical tree with long, feather-like leaves.", "Tropical and Subtropical Regions", "Ornamental use, Food (fruits), Construction", "Tall tree with a single unbranched trunk.", "Prone to fungal diseases and nutrient deficiencies.", "Fusarium wilt, palm weevils");
//        db.insert(5, "Redwood", "Sequoia sempervirens", "A giant evergreen tree with reddish bark and scale-like leaves.", "Coastal California", "Timber, Ornamental use", "Tallest tree species with a conical crown.", "Prefers moist, coastal climate and well-drained soil.", "Sudden oak death, fungal diseases");




            Log.d("EXCEC_INITIAL","Table inserted");
        } else{
            Log.d("EXCEC_INITIAL","Table existed");
        }



    }



    public void btn_continue_pressed(View view) {
        Intent intent = new Intent(this,MainMenu.class);
        startActivity(intent);
    }
}