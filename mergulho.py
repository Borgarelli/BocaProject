import sys

def voluntarios_perdidos(N, R, retornados):
    todos = set(range(1, N+R+1))
    retornados = set(retornados)
    perdidos = todos - retornados
    if perdidos:
        return ' '.join(map(str, sorted(perdidos)))
    else:
        return '*'

if __name__ == "__main__":
    N = int(sys.argv[1])
    R = int(sys.argv[2])
    retornados = list(map(int, sys.stdin.read().strip().split()))

    print(voluntarios_perdidos(N, R, retornados))
