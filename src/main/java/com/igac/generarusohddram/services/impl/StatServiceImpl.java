package com.igac.generarusohddram.services.impl;

import com.igac.generarusohddram.models.Disco;
import com.igac.generarusohddram.models.Estadistica;
import com.igac.generarusohddram.services.StatService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatServiceImpl implements StatService {

    DecimalFormat format = new DecimalFormat("#,00");

    @Override
    public Estadistica obtenerRamHdd() {
        File[] unidades = File.listRoots();
        List<Disco> discos = new ArrayList<>();

        for(File f : unidades){

            discos.add(new Disco(
                    f.getAbsolutePath().toString(),
                    bytesToGigaBytes( f.getTotalSpace() ),
                    bytesToGigaBytes( f.getFreeSpace() ),
                    bytesToGigaBytes( f.getTotalSpace() - f.getFreeSpace() )
                    )
            );

        }

        return new Estadistica  (
                discos,
                Double.parseDouble( format.format(  bytesToMegabytes( Runtime.getRuntime().totalMemory() ) ) ),
                Double.parseDouble( format.format(   bytesToMegabytes( Runtime.getRuntime().totalMemory() + - Runtime.getRuntime().freeMemory() ) ) ),
                Double.parseDouble( format.format(  bytesToMegabytes( Runtime.getRuntime().totalMemory() ) ) )
        );
    }






    private double bytesToMegabytes(long bytes){
        return (double) (bytes / 1048576);
    }
    private double bytesToGigaBytes(long bytes){return (double) (bytes / 1073741824);}

}
