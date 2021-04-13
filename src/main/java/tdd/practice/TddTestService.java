package tdd.practice;

import org.springframework.stereotype.Service;
import tdd.practice.entity.UserName;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TddTestService {

    private final UserNameRepository userNameRepository;

    public TddTestService(UserNameRepository userNameRepository){
        this.userNameRepository = userNameRepository;
    }


    public UserName add(UserName userName) {
        return userNameRepository.save(userName);
    }

    public boolean isRegistered(String name) {
        Long result = userNameRepository.countByUserName(name);
        if(result > 0) return true;
        else return false;
    }

    private ArrayList<String> addToAnaList(String ana, ArrayList<String> anagrams){
        if(!anagrams.contains(ana)){
            anagrams.add(ana);
        }else{
            char[] replaceDub = ana.toCharArray();
            int randomC = (int)(Math.random() * replaceDub.length);
            int randomD= (int)(Math.random() * replaceDub.length);
            char temp = replaceDub[randomC];
            replaceDub[randomC] = replaceDub[randomD];
            replaceDub[randomD] = temp;
            String anotherAna = new String(replaceDub);
            anagrams = addToAnaList(anotherAna, anagrams);
        }
        return anagrams;
    }

    public ArrayList<String> getAnagrams(String name) {
        ArrayList<String> anagrams = new ArrayList<>();
        char[] charPool = name.toCharArray();
        anagrams.add(name);
        for(int i= 0; i<3;i++){
            for(int j = 0; j<charPool.length;j++){
                int randomA = (int)(Math.random() * charPool.length);
                int randomB = (int)(Math.random() * charPool.length);
                //System.out.println(randomA);
                char temp = charPool[randomA];
                charPool[randomA] = charPool[randomB];
                charPool[randomB] = temp;
            }
            String ana = new String(charPool);
            anagrams = addToAnaList(ana, anagrams);
        }
        System.out.println(anagrams);
        return anagrams;
    }

    public void updateName(UserName selectedUserName) {
        Optional<UserName> target = userNameRepository.findById(selectedUserName.getId());
        target.ifPresent(userName -> {
            System.out.println(userName.getUserName());
            System.out.println(selectedUserName.getUserName());
            selectedUserName.setCreatedTime(userName.getCreatedTime());
            UserName result = userNameRepository.save(selectedUserName);
        });
    }

    public void deleteNameById(Long id) {
         Optional<UserName> target =  userNameRepository.findById(id);
         target.ifPresent(selectTarget->{
             userNameRepository.delete(selectTarget);
         });
    }
}
