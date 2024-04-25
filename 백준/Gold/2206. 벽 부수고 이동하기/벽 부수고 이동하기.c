#include <stdio.h>

int N,M;

char map[1001][1001];
int distance[2][1001][1001];
int x[4] = { 1,0,-1,0 };
int y[4] = { 0,1,0,-1 };

int queue[1000 * 1000*2];
int first = 0, last = 0;
int min=99999999;

int Min(int a, int b)
{
	return a < b ? a : b;
}

void enqueue(int v)
{
	queue[last++] = v;
}

int dequeue()
{
	int temp = queue[first];
	queue[first++] = 0;
	return temp;
}

int doBFS()
{
	distance[0][0][0] = 1;
	distance[1][0][0] = 1;

	enqueue(0);

	while (first != last)
	{
		int cur = dequeue();
		int cur_x = cur % M;
		int cur_y = (cur / M) % N;
		int cur_z = (cur / M) / N;

		if (cur_x == M - 1 && cur_y == N - 1)
		{
			return cur_z;
		}

		for (int i = 0; i < 4; i++)
		{
			int next_x = cur_x + x[i];
			int next_y = cur_y + y[i];

			if (next_x < 0 || next_x >= M || next_y < 0 || next_y >= N)
			{
				continue;
			}
			if (map[next_y][next_x] == '0'&&distance[cur_z][next_y][next_x]==0)
			{
				distance[cur_z][next_y][next_x] = distance[cur_z][cur_y][cur_x] + 1;
				enqueue(N*M*cur_z + next_y * M + next_x);
			}
			else if (map[next_y][next_x] == '1'&&cur_z==0)
			{
				distance[1][next_y][next_x] = distance[0][cur_y][cur_x] + 1;
				enqueue(N*M + next_y * M + next_x);
			}
		}
	}
	return 1;
}

int main()
{
	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; i++)
	{
		scanf("%s", map[i]);
	}

	int z=doBFS();

	if (distance[z][N-1][M-1]==0)
	{
		printf("-1");
	}
	else
	{
		printf("%d", distance[z][N-1][M-1]);
	}
}