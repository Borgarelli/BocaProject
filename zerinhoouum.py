import sys

def zerinho_ou_um(A, B, C):
    if A != B and A != C:
        return 'A'
    elif B != A and B != C:
        return 'B'
    elif C != A and C != B:
        return 'C'
    else:
        return '*'

if __name__ == "__main__":
    A = int(sys.argv[1])
    B = int(sys.argv[2])
    C = int(sys.argv[3])

    print(zerinho_ou_um(A, B, C))
