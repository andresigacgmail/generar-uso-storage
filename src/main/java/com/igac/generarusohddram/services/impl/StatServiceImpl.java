package com.igac.generarusohddram.services.impl;

import com.igac.generarusohddram.models.Disco;
import com.igac.generarusohddram.models.Estadistica;
import com.igac.generarusohddram.services.StatService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Service
public class StatServiceImpl implements StatService {


    @Override
    public Estadistica obtenerRamHdd() {
        File[] unidades = File.listRoots();
        List<Disco> discos = new ArrayList<>();

        for(File f : unidades){

            discos.add(new Disco(
                    f.getAbsolutePath(),
                    bytesToGigaBytes( f.getTotalSpace() ),
                    bytesToGigaBytes( f.getFreeSpace() ),
                    bytesToGigaBytes( f.getTotalSpace() - f.getFreeSpace() )
                    )
            );

        }

        return new Estadistica  (
                discos,
                bytesToMegabytes( Runtime.getRuntime().totalMemory() )  ,
                bytesToMegabytes( Runtime.getRuntime().totalMemory() + - Runtime.getRuntime().freeMemory() ) ,
                bytesToMegabytes( Runtime.getRuntime().totalMemory() )
                //Double.parseDouble( format.format(  bytesToMegabytes( Runtime.getRuntime().totalMemory() ) ) ),
        );
    }






    private double bytesToMegabytes(long bytes){
        return (double) (bytes / 1048576);
    }
    private double bytesToGigaBytes(long bytes){return (double) (bytes / 1073741824);}

}
