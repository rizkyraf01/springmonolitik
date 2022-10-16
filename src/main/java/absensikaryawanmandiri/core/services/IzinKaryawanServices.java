package absensikaryawanmandiri.core.services;

import absensikaryawanmandiri.core.models.entity.absensi_karyawan;
import absensikaryawanmandiri.core.models.entity.izin_karyawan;
import absensikaryawanmandiri.core.models.repository.IzinKaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IzinKaryawanServices {

    @Autowired
    private IzinKaryawanRepository izinKaryawanRepository;

    public Iterable<izin_karyawan> findAll(){
        return izinKaryawanRepository.findAll();
    }

    public izin_karyawan addIzin(izin_karyawan izinkaryawan){

        izinKaryawanRepository.save(izinkaryawan);
        return izinkaryawan;

    }
}
