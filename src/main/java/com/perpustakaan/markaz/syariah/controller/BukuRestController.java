package com.perpustakaan.markaz.syariah.controller;

import com.perpustakaan.markaz.syariah.domain.Buku;
import com.perpustakaan.markaz.syariah.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rizki on 27/06/15.
 */

@RestController
@RequestMapping(value = "/api")
public class BukuRestController {

    @Autowired
    private BukuService bukuService;

    @RequestMapping(value = "/buku", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Buku> getBukus(){
        return bukuService.getBukus();
    }

    @RequestMapping(value = "/buku/{key}/{value}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Buku> searchBuku(@PathVariable("key")String key, @PathVariable("value")String value){
        return bukuService.searchBuku(key, value);
    }

    @RequestMapping(value = "/buku/{noKode}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Buku getBuku(@PathVariable("noKode")String noKode){
        return bukuService.getBuku(noKode);
    }

    @RequestMapping(value = "/buku", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> updateBuku(@RequestBody Buku buku){
        bukuService.update(buku);

        Map<String, Object> objectsMap = new HashMap<>();
        objectsMap.put("success", Boolean.TRUE);
        objectsMap.put("Info", "Data di edit");

        return objectsMap;
    }

    @RequestMapping(value = "/buku/{noKode}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> deleteBuku(@PathVariable("noKode")String noKode){
        bukuService.delete(bukuService.getBuku(noKode));

        Map<String, Object> objectsMap = new HashMap<>();
        objectsMap.put("success", Boolean.TRUE);
        objectsMap.put("Info", "Data di hapus");

        return objectsMap;
    }

}
