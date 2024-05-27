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

        Cursor pests = db.PEST_fetch(null,null);
        Cursor disease = db.DISEASE_fetch(null,null);

        Log.d("EXCEC_INITIAL", String.valueOf(cursor.getCount()));

        if (cursor.getCount() == 0){
        String xxx = String.valueOf(R.drawable.images);
        db.insert(1,"Almon", "Shorea almon", "The Almon tree, known scientifically as Shorea almon, is a tropical hardwood species belonging to the Dipterocarpaceae family. Native to the Philippines, it is highly regarded for its durable and high-quality timber. Typically found in lowland dipterocarp forests, the Almon tree can grow to impressive heights.", "Philippines", "The wood of the Almon tree is highly valued in the timber industry due to its strength and durability. It is commonly used in construction for flooring, furniture, cabinetry, and boat building. Additionally, Almon wood is utilized in the production of veneers and plywood. Its aesthetic appeal and workability make it a popular choice for various woodworking projects.", "Almon trees can reach heights of up to 45 meters with trunk diameters growing up to 1.5 meters. The leaves are simple, alternate, and oblong to elliptic in shape, typically measuring 8-15 cm in length. The tree produces small, creamy-white flowers that grow in clusters, and its fruit is a winged nut, aiding in wind dispersal.", "To care for an Almon seedling, choose a planting site with well-drained, fertile soil and adequate sunlight. Keep the soil consistently moist, especially during the seedling’s early growth stages, and use a balanced fertilizer to promote healthy growth, following the manufacturer’s instructions. Applying a layer of mulch around the base of the seedling will help retain soil moisture and reduce weed competition. Protect the seedling from strong winds and direct sun exposure by providing partial shade or using protective barriers, and regularly monitor for signs of pests or diseases, taking appropriate action if any issues are detected.", "Borers, Leaf Miners, Scale Insects ,Termites",xxx);

        xxx = String.valueOf(R.drawable.mayapis);

        db.insert(2, "Mayapis", "Shorea palosapis",
                "The Mayapis tree, scientifically known as Shorea palosapis, is a tropical hardwood species in the Dipterocarpaceae family. It is native to Southeast Asia, particularly the Philippines. The tree is renowned for its strong and durable timber, making it valuable in various industries. Mayapis trees are typically found in lowland dipterocarp forests and are known for their tall and straight growth.",
                "Philippines, Malaysia, Indonesia",
                "Mayapis wood is highly prized in the timber industry for its strength, durability, and fine grain. It is widely used in construction for flooring, furniture, paneling, and plywood. The wood is also utilized in boat building and for making high-quality veneer. Its aesthetic qualities and workability make it a preferred choice for many woodworking projects.",
                "Mayapis trees can grow up to 50 meters in height with trunk diameters reaching up to 2 meters. The leaves are simple, alternate, and ovate to elliptic in shape, typically measuring 7-15 cm in length. The tree produces small, white to pale yellow flowers that grow in clusters. The fruit is a winged nut, aiding in wind dispersal, characteristic of the Dipterocarpaceae family.",
                "To care for a Mayapis seedling, select a planting site with well-drained, fertile soil and sufficient sunlight. Keep the soil consistently moist, particularly during the seedling’s early growth stages, and use a balanced fertilizer to encourage healthy growth, following the manufacturer’s instructions. Applying a layer of mulch around the base of the seedling will help retain soil moisture and minimize weed competition. Protect the seedling from strong winds and direct sun exposure by providing partial shade or using protective barriers. Regularly check for signs of pests or diseases and take appropriate action if any issues are detected.",
                "Borers, Leaf Miners, Scale Insects, Termites",
                xxx
        );
            xxx = String.valueOf(R.drawable.narra);


            db.insert(3, "Narra", "Pterocarpus indicus",
                    "The Narra tree, scientifically known as Pterocarpus indicus, is a large deciduous tree belonging to the Fabaceae family. It is native to Southeast Asia and the western Pacific regions. The Narra tree is celebrated for its beautiful and durable timber, which is used in fine woodworking and furniture making. It is also known for its vibrant yellow flowers and its use as an ornamental and shade tree in tropical regions.",
                    "Philippines, Malaysia, Indonesia, Thailand, Vietnam, Papua New Guinea, Solomon Islands",
                    "Narra wood is highly valued for its rich, reddish-brown color, durability, and fine grain. It is widely used in high-quality furniture, flooring, cabinetry, and interior decoration. The wood is also used in boat building and for making musical instruments. Narra is popular for its resistance to termites and wood-boring insects, making it ideal for long-lasting structures. Additionally, the tree is often planted as an ornamental and shade tree in parks and gardens due to its attractive flowers and broad canopy.",
                    "Narra trees can grow up to 30-40 meters in height with trunk diameters reaching up to 2 meters. The leaves are compound, with 5-9 leaflets that are ovate to elliptical in shape, typically measuring 5-12 cm in length. The tree produces bright yellow, fragrant flowers that bloom in clusters, usually during the dry season. The fruit is a flat, disc-shaped pod with a single seed, adapted for wind dispersal.",
                    "To care for a Narra seedling, select a planting site with well-drained, fertile soil and full to partial sunlight. Water the seedling regularly to keep the soil consistently moist, especially during its early growth stages. Apply a balanced fertilizer to promote healthy growth, following the manufacturer's instructions. Mulching around the base of the seedling helps retain soil moisture and reduce weed competition. Protect the seedling from strong winds and direct sun exposure by providing partial shade or using protective barriers. Regularly monitor for signs of pests or diseases and take appropriate action if any issues are detected.",
                    "Borers, Leaf Miners, Scale Insects, Termites, Aphids, Mealybugs",
                    xxx
            );
            xxx = String.valueOf(R.drawable.tanguile);


            db.insert(4, "Tanguile", "Shorea polysperma",
                    "The Tanguile tree, known scientifically as Shorea polysperma, is a tropical hardwood species within the Dipterocarpaceae family. It is native to the Philippines and is one of the many species of red Lauan group. Tanguile wood is valued for its versatility and moderate durability, making it a common choice for various construction and woodworking applications.",
                    "Philippines",
                    "Tanguile wood is widely used in the construction industry due to its strength and workability. It is commonly used for interior construction purposes such as framing, flooring, doors, and furniture. Additionally, Tanguile is utilized in the manufacture of plywood and veneers. Its relatively affordable price and availability make it a popular choice for a range of building and woodworking projects.",
                    "Tanguile trees can reach heights of up to 50 meters with trunk diameters of up to 1.5 meters. The leaves are simple, alternate, and elliptic to oblong in shape, typically measuring 8-15 cm in length. The tree produces small, creamy-white to yellowish flowers that grow in clusters. The fruit is a winged nut, which helps in wind dispersal, a characteristic feature of the Dipterocarpaceae family.",
                    "To care for a Tanguile seedling, choose a planting site with well-drained, fertile soil and sufficient sunlight. Keep the soil consistently moist, particularly during the early stages of growth, and apply a balanced fertilizer to promote healthy development, according to the manufacturer's instructions. Mulching around the base of the seedling can help retain soil moisture and reduce weed competition. Protect the seedling from strong winds and direct sun exposure by providing partial shade or using protective barriers. Regular monitoring for signs of pests or diseases is important, and appropriate actions should be taken if any issues are detected.",
                    "Borers, Leaf Miners, Scale Insects, Termites",
                    xxx
            );
            xxx = String.valueOf(R.drawable.white_lauan);


            db.insert(5, "White Lauan", "Shorea contorta",
                    "The White Lauan tree, scientifically known as Shorea contorta, is a tropical hardwood species in the Dipterocarpaceae family. Native to Southeast Asia, particularly the Philippines, it is one of several species grouped under the general term 'Lauan,' which includes various types of Philippine mahogany. White Lauan is known for its lighter-colored timber, which is widely used in various construction and woodworking applications.",
                    "Philippines, Malaysia, Indonesia",
                    "White Lauan wood is highly valued in the construction industry due to its light color, moderate strength, and ease of workability. It is commonly used for interior construction, including paneling, ceilings, and furniture. The wood is also utilized in the production of plywood, veneers, and packaging materials. Its relatively low cost and wide availability make it a popular choice for a variety of building and woodworking projects.",
                    "White Lauan trees can reach heights of up to 50 meters, with trunk diameters growing up to 1.5 meters. The leaves are simple, alternate, and oblong to elliptic in shape, typically measuring 8-15 cm in length. The tree produces small, white to pale yellow flowers that grow in clusters. The fruit is a winged nut, aiding in wind dispersal, a characteristic feature of the Dipterocarpaceae family.",
                    "To care for a White Lauan seedling, select a planting site with well-drained, fertile soil and adequate sunlight. Water the seedling regularly to keep the soil consistently moist, especially during its early growth stages. Use a balanced fertilizer to promote healthy growth, following the manufacturer's instructions. Mulching around the base of the seedling will help retain soil moisture and reduce weed competition. Protect the seedling from strong winds and direct sun exposure by providing partial shade or using protective barriers. Regularly monitor for signs of pests or diseases and take appropriate action if any issues are detected.",
                    "Borers, Leaf Miners, Scale Insects, Termites, Aphids, Mealybugs",
                    xxx
            );

            xxx = String.valueOf(R.drawable.__ambrosia);

            db.PEST_insert(
                    1,
                    "Ambrosia beetle",
                    "Varies depending on species (e.g., Xyleborus affinis)",
                    "Small (3-5mm), cylindrical body, varies in color (yellowish, brown, reddish)",
                    "Curculionidae (weevils), subfamilies Scolytinae and Platypodinae",
                    "Primarily dead or stressed trees, some attack living trees",
                    "Tiny holes in bark, toothpick-like frass (sawdust) protruding from holes",
                    "Maintain tree health, remove infested wood promptly, trap and insecticidal treatments (consult a professional)",
                    xxx
            );


            xxx = String.valueOf(R.drawable.__ips);

            db.PEST_insert(
                    2,
                    "Six-spined spruce bark beetle, Ips typographus",
                    "Ips typographus",
                    "Cylindrical, reddish-brown to black, about 5mm long with six spines on thorax",
                    "Curculionidae (weevils), subfamily Scolytinae",
                    "Primarily spruce trees (especially Norway spruce)",
                    "Reddish boring dust around entrance holes, resinosis (pitch flow), thinning foliage",
                    "Maintain forest health, remove infested trees promptly, pheromone traps",
                    xxx
            );
            xxx = String.valueOf(R.drawable.__mealy);

            db.PEST_insert(
                    3,
                    "Mealybug",
                    "Varies depending on species (e.g., Pseudococcus citri)",
                    "Soft-bodied, oval insects covered in white waxy filaments, females larger than males",
                    "Pseudococcidae",
                    "Wide range of plants, including fruits, vegetables, ornamentals",
                    "Yellowing leaves, stunted growth, sooty mold on leaves due to honeydew excretion",
                    "Insecticidal soap sprays, horticultural oil, natural enemies (ladybugs, lacewings)",
                    xxx
            );
            xxx = String.valueOf(R.drawable.__pach);

            db.PEST_insert(
                    4,
                    "Weevil, Rhinoceros beetle (depending on species)",
                    "Pachyrhynchus spp.",
                    "Varies depending on species, often have a characteristic elongated snout",
                    "Curculionidae (weevils)",
                    "Wide range of plants, including fruits, nuts, ornamentals",
                    "Notched leaves, holes in fruits and nuts, damage to buds and flowers",
                    "Physical removal, insecticidal sprays, row covers to protect young plants",
                    xxx
            );
            xxx = String.valueOf(R.drawable.__woodboring);

            db.PEST_insert(
                    5,
                    "Wood boring beetle (broad term)",
                    "Varies depending on species (e.g., Anobium punctatum)",
                    "Varies depending on species, size and shape can vary greatly",
                    "Can belong to several families, including Cerambycidae (longhorn beetles), Buprestidae (metallic wood-boring beetles)",
                    "Wide range of wood sources, including dead or live trees, furniture, structures",
                    "Round exit holes, sawdust around holes, weakened wood structure",
                    "Identify specific beetle for targeted control, apply wood treatments, promote good ventilation in crawl spaces",
                    xxx
            );

            xxx = String.valueOf(R.drawable.__blight);

            // Blight
            db.DISEASE_insert(
                    1,
                    "Blight",
                    "Brown or black spots, wilting, stunting, oozing lesions (depending on type)",
                    "Fungus (most common), Bacteria (less common)",
                    "Wide range of plants (vegetables, fruits, flowers, trees)",
                    "Cultural: Proper watering, air circulation, sanitation, crop rotation Chemical: Fungicides/bactericides (consult a professional)",
                    "Cultural: Remove debris, sanitation, avoid injuring plants",
                    "Chemical: Limited effectiveness (consult a professional)", // Assuming Images is for a separate field
                    xxx);

//            // Gall
            xxx = String.valueOf(R.drawable.__gall);

            db.DISEASE_insert(
                    2,
                    "Gall",
                    "Abnormal growths on leaves, stems, etc., distorted plant tissue",
                    "Fungus, Bacteria, Virus, Nematode",
                    "Wide range of plants",
                    "Cultural: Remove galls, promote healthy growth\nChemical: Limited effectiveness (consult a professional)",
                    "Cultural: Remove galls, avoid injuring plants",
                    "Chemical: Not applicable", // Assuming Images is for a separate field
                    xxx);

            xxx = String.valueOf(R.drawable.__mosiac);

            // Mosaic
            db.DISEASE_insert(
                    3,
                    "Mosaic",
                    "Distorted leaves with mottled patterns, stunted growth",
                    "Virus",
                    "Wide range of plants",
                    "Cultural: Control insect vectors, use resistant varieties, rogue infected plants",
                    "Chemical: Not applicable",
                    "Chemical: Not applicable", // Assuming Images is for a separate field
                    xxx);

            xxx = String.valueOf(R.drawable.__scab);

            db.DISEASE_insert(
                    4,
                    "Scab",
                    "Rough, scabby patches on fruits, tubers, or roots",
                    "Fungus, Bacteria",
                    "Vegetables, fruits, some ornamentals",
                    "Cultural: Good drainage, crop rotation, resistant varieties, avoid wounding\nChemical: Fungicides (consult a professional)",
                    "Cultural: Good drainage, crop rotation, resistant varieties",
                    "Chemical: Consult a professional", // Assuming Images is for a separate field
                    xxx);

            // Spot
            xxx = String.valueOf(R.drawable.__spot);

            db.DISEASE_insert(
                    5,
                    "Spot",
                    "Small, circular spots on leaves, fruits, or stems (color varies)",
                    "Fungus, Bacteria, Algae (less common)",
                    "Wide range of plants",
                    "Cultural: Proper watering, air circulation, remove debris\nChemical: Fungicides/bactericides (consult a professional)",
                    "Cultural: Proper watering, air circulation, remove debris",
                    "Chemical: Consult a professional", // Assuming Images is for a separate field
                    xxx);










            Log.d("EXCEC_INITIAL","Table inserted");
        } else{
            Log.d("EXCEC_INITIAL","Table existed");

        }


        String xy = String.valueOf(pests.getCount());

        String xx = String.valueOf(disease.getCount());

        Log.d("PEST_TAG",xy);
        Log.d("D_TAG",xx);



    }



    public void btn_continue_pressed(View view) {
        Intent intent = new Intent(this,MainMenu.class);
        startActivity(intent);
    }
}