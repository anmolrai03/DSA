from itertools import combinations
from collections import defaultdict
from math import isclose

def calculate_polygon_area(vertices):
    n = len(vertices)
    area = 0
    for i in range(n):
        x1, y1 = vertices[i]
        x2, y2 = vertices[(i+1) % n]
        area += x1*y2-y1*x2
    return abs(area) // 2
def cross_product(o,a,b):
    return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1])* (b[0]-o[0])

def segments_intersect(p1,p2,q1,q2):
    d1 = cross_product(q1 , q2 , p1)
    d2 = cross_product(q1 , q2 , p2)
    d3 = cross_product(p1 , p2 , q1)
    d4 = cross_product(p1 , p2 , q2)

    if d1 * d2 < 0 and d3*d4 < 0:
        return True
    return False

def dfs(graph , start , visited , path):
    path.append(start)
    visited.add(start)

    for neighbor in graph[start]:
        if neighbor == path[0] and len(path)>2:
            return path
        if neighbor not in visited:
            result = dfs(graph, neighbor , visited, path)
            if result:
                return result
    
    path.pop()
    return None

def find_closed_polygons(segments):
    graph = defaultdict(list)
    points = set()

    for x1,y1,x2,y2 in segments:
        p1,p2 = (x1,y1),(x2,y2)
        graph[p1].append(p2)
        graph[p2].append(p1)
        points.update([p1,p2])

    polygons= [] 
    visited_edges = set()

    for start in points:
        for neighbor in graph[start]:
            edge = tuple(sorted((start , neighbor)))
            if edge in visited_edges:
                continue
            visited_edges.add(edge)

            visited = set()
            path = []
            polygon = dfs(graph, start , visited, path)
            if polygon:
                polygons.append(polygon)
    return polygons

def main():
    N = int(input())
    segments = [tuple(map(int , input().split())) for _ in range(N)]

    polygons = find_closed_polygons(segments)


    max_area = 0
    for polygon in polygons:
        area = calculate_polygon_area(polygon)
        max_area = max(max_area , area)

    print(max_area)


main()
