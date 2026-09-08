def f(a, b):
    if not isinstance(a, int) or not isinstance(b, int):
        raise TypeError("Only Integers are Allowed")

    if a == 0 and b < 0:
        raise ValueError("Indéfini")

    resultat = 1
    for i in range(abs(b)):
        resultat = resultat * a
    
    if b < 0:
        return 1 / resultat

    return resultat