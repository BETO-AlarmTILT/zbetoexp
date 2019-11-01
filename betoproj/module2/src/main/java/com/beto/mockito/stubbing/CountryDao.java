package com.beto.mockito.stubbing;

import java.util.List;

public interface CountryDao {

    List<Country> retrieve(RetrieveCountryRequest command);
}
