package com.perpustakaan.markaz.syariah.controller;

import com.perpustakaan.markaz.syariah.domain.Buku;
import com.perpustakaan.markaz.syariah.domain.Peminjaman;
import com.perpustakaan.markaz.syariah.service.BukuService;
import com.perpustakaan.markaz.syariah.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by rizki on 27/06/15.
 */

@RestController
@RequestMapping(value = "/api")
public class PeminjamanController {

    @Autowired
    private PeminjamanService peminjamanService;

    @Autowired
    private BukuService bukuService;

    @RequestMapping(value = "/peminjaman", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Map<String, Object>> getPeminjamans(){

        List<Map<String, Object>> mapList = new ArrayList<>();

        for(Buku buku : bukuService.getBukus()){
            for(Peminjaman peminjaman: buku.getPeminjamans()){
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("judulBuku1", buku.getJudul1());
                objectMap.put("idPeminjaman", peminjaman.getIdPeminjaman());
                objectMap.put("namaPeminjam", peminjaman.getNamaPeminjam());
                objectMap.put("alamat", peminjaman.getAlamat());
                objectMap.put("noKontak", peminjaman.getNoKontak());
                objectMap.put("tglPeminjaman", peminjaman.getTglPeminjaman());
                objectMap.put("tglPengembalian", peminjaman.getTglPengembalian());
                mapList.add(objectMap);
            }
        }

        return mapList;
    }

    @RequestMapping(value = "/peminjaman/{noKode}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> savePeminjaman(@RequestBody Peminjaman peminjaman, @PathVariable("noKode")String noKode){

        peminjamanService.save(peminjaman, noKode);

        Map<String, Object> objectsMap = new HashMap<>();
        objectsMap.put("success", Boolean.TRUE);
        objectsMap.put("Info", "Data di simpan");

        return objectsMap;
    }

    @RequestMapping(value = "/peminjaman/{idPeminjaman}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> deletePeminjaman(@PathVariable("idPeminjaman")String idPeminjaman){
        peminjamanService.delete(idPeminjaman);

        Map<String, Object> objectsMap = new HashMap<>();
        objectsMap.put("success", Boolean.TRUE);
        objectsMap.put("Info", "Data di hapus");

        return objectsMap;
    }

}
