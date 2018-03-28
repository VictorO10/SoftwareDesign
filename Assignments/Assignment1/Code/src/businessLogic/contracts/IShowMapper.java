package businessLogic.contracts;

import businessLogic.model.ShowModel;
import dataAccess.model.ShowDto;

public interface IShowMapper {

    ShowModel map(ShowDto showDto);
    ShowDto map(ShowModel showModel);
}
