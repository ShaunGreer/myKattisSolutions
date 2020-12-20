import Data.List.Split

main :: IO()
main = do
  input <- getContents
  let eachCase = tail (init (splitOn "\n" input))
  let result = controller eachCase
  mapM_ putStrLn result

controller :: [String] -> [String]
controller [] = []
controller (x:xs) = do
  let params = toIntList (splitOn " " x)
  (checkSafety (params !! 0) (params !! 1) (params !! 2) (params !! 3) (params !! 4)) : controller xs

checkSafety :: Float -> Float -> Float -> Float -> Float -> String
checkSafety v angle x h1 h2 = do
  let angleRad = angle * (pi / 180)
  let t = x / (v * (cos angleRad))
  let y = v * t * (sin angleRad) - 0.5 * 9.81 * t^2
  if (h2 - y > 1) && (y - h1 > 1)
    then "Safe"
    else "Not Safe"

toIntList :: [String] -> [Float]
toIntList = map read
