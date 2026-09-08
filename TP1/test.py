import pytest 
import fonctions as f 

def test_1():
	assert f.f(2,3) == 8 
	assert f.f(2,2) == 4 

def test_2():
    assert f.f(-1, 2) == 1
    assert f.f(-1, 3) == -1
    assert f.f(-1, -1) == -1
    assert f.f(-1, -2) == 1
    assert f.f(-2, -1) == -0.5
    
def test_3():
    # Cas 0^x = 0 pour x > 0
    assert f.f(0, 1) == 0
    assert f.f(0, 5) == 0

    # Cas x^0 = 1
    assert f.f(5, 0) == 1
    assert f.f(-3, 0) == 1
    
    with pytest.raises(ValueError):
        f.f(0, -1)
    with pytest.raises(ValueError):
        f.f(0, -2)
