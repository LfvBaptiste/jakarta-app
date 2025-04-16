package fr.formation.jakarta.model.service;


import fr.formation.jakarta.model.entity.VintageCamera;

import java.util.ArrayList;
import java.util.List;

public class VintageCameraService {

    // Méthode pour obtenir une liste d'appareils photo anciens
    public List<VintageCamera> getCameras() {
        List<VintageCamera> cameras = new ArrayList<>();

        cameras.add(new VintageCamera(1, "Leica M3", "Leica", 1954, 2500.00, "Germany", "35mm"));
        cameras.add(new VintageCamera(2, "Canon AE-1", "Canon", 1976, 300.00, "Japan", "35mm"));
        cameras.add(new VintageCamera(3, "Nikon F", "Nikon", 1959, 1500.00, "Japan", "35mm"));
        cameras.add(new VintageCamera(4, "Pentax Spotmatic", "Pentax", 1964, 400.00, "Japan", "35mm"));
        cameras.add(new VintageCamera(5, "Rolleiflex 2.8F", "Rollei", 1960, 3500.00, "Germany", "Medium Format"));
        cameras.add(new VintageCamera(6, "Hasselblad 500C/M", "Hasselblad", 1957, 4500.00, "Sweden", "Medium Format"));
        cameras.add(new VintageCamera(7, "Kodak Retina IIa", "Kodak", 1951, 200.00, "USA", "35mm"));
        cameras.add(new VintageCamera(8, "Olympus OM-1", "Olympus", 1972, 250.00, "Japan", "35mm"));
        cameras.add(new VintageCamera(9, "Minolta X-700", "Minolta", 1981, 200.00, "Japan", "35mm"));
        cameras.add(new VintageCamera(10, "Yashica Mat-124G", "Yashica", 1970, 300.00, "Japan", "Medium Format"));
        cameras.add(new VintageCamera(11, "Contax RTS II", "Contax", 1982, 500.00, "Germany/Japan", "35mm"));
        cameras.add(new VintageCamera(12, "Argus C3 Brick", "Argus", 1939, 100.00, "USA", "35mm"));
        cameras.add(new VintageCamera(13, "Polaroid SX-70", "Polaroid", 1972, 250.00, "USA", "Instant Film"));
        cameras.add(new VintageCamera(14, "Mamiya RB67 Pro-SD", "Mamiya", 1974, 800.00, "Japan", "Medium Format"));
        cameras.add(new VintageCamera(15, "Voigtländer Bessa R2A", "Voigtländer", 2002, 600.00, "Germany/Japan", "35mm"));
        cameras.add(new VintageCamera(16, "Zeiss Ikon Contaflex Super B", "Zeiss Ikon", 1959, 350.00, "Germany", "35mm"));
        cameras.add(new VintageCamera(17, "FED-2 Rangefinder Camera", "FED (Soviet)", 1955, 100.00, "USSR (Russia)", "35mm"));
        cameras.add(new VintageCamera(18, "Zorki-4K Rangefinder Camera", "Zorki (Soviet)", 1972, 120.00, "USSR (Russia)", "35mm"));
        cameras.add(new VintageCamera(19, "Exakta VX IIa SLR Camera", "Exakta Ihagee Dresden", 1956, 300.00, "Germany (East)", "35mm"));

        return cameras;

    }
}
