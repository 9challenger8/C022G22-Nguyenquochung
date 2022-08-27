export function calculateDay(startDay: string, endDay: string): number {
    const start = new Date(startDay);
    const end = new Date(endDay);
    let year = end.getFullYear() - start.getFullYear();
    let month = end.getMonth() -start.getMonth();
    let day = end.getDate() - start.getDate();
    return day + month * 30 + year * 365;
}
