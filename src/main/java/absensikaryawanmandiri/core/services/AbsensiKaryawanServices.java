package absensikaryawanmandiri.core.services;

import absensikaryawanmandiri.core.models.entity.absensi_karyawan;
import absensikaryawanmandiri.core.models.repository.AbsensiKaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AbsensiKaryawanServices {

    @Autowired
    private AbsensiKaryawanRepository absensiKaryawanRepository;
    private DaftarKaryawanServices daftarKaryawanServices;
    ///coba ini bener////
    public Iterable<absensi_karyawan> findAll(){

        return absensiKaryawanRepository.findAll();
    }



    public absensi_karyawan addAbsensi(absensi_karyawan addabsensi){

        absensiKaryawanRepository.save(addabsensi);
        return addabsensi;

    }

    public void deleteAbsensiById(long id){
        absensiKaryawanRepository.deleteById(id);
    }
    public Optional<absensi_karyawan>absensiAbsensiById(long id){
        return absensiKaryawanRepository.findById(id);
    }

    public void updateAbsensi(absensi_karyawan updateAbsensi){
        absensiKaryawanRepository.save(updateAbsensi);
    }
}
