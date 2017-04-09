package tecnicas.software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tecnicas.software.model.Memo;
import tecnicas.software.repository.MemoRepository;

/**
 * Created by Luis Marrero on 9/4/2017.
 */
@Service
public class MemoService {

    MemoRepository memoRepository;

    @Autowired
    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Memo getByID(Integer id) {
        return memoRepository.findOne(id);
    }

    public Memo getLast() {
        return memoRepository.getLast();
    }

    public Memo seLast(Integer id) {
        Memo memo = new Memo();
        memo.setId(id);
        memoRepository.save(memo);
        return memoRepository.getLast();
    }
}
